package edu.uh.tech.cis3368.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class ExamService {

    private ServerRepository serverRepository;


    @Autowired
    public ExamService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }


    public void createData() {

        Server server= new Server();
        server.setName("Web");
        server.setLocation("T2 120");
        server.setReplacementCost(new BigDecimal("4424.73"));
        server.setRunningCost(new BigDecimal("0.002"));
        serverRepository.save(server);

        Server server2= new Server();
        server.setName("HR");
        server.setLocation("T2 110");
        server.setReplacementCost(new BigDecimal("1549.14"));
        server.setRunningCost(new BigDecimal("0.0010"));
        serverRepository.save(server2);

        Server server3= new Server();
        server.setName("DNS");
        server.setLocation("T3 121");
        server.setReplacementCost(new BigDecimal("4040.34"));
        server.setRunningCost(new BigDecimal("0.0021"));
        serverRepository.save(server3);

        Server server4= new Server();
        server.setName("DNS2");
        server.setLocation("T3 121");
        server.setReplacementCost(new BigDecimal("4494.27"));
        server.setRunningCost(new BigDecimal("0.001"));
        serverRepository.save(server4);

        Server server5= new Server();
        server.setName("Application");
        server.setLocation("T2 110");
        server.setReplacementCost(new BigDecimal("2904.27"));
        server.setRunningCost(new BigDecimal("0.02"));
        serverRepository.save(server5);


    }

    public BigDecimal calculateTotalRunningCost (){


        // get a list of all servers
        Iterable<Server> servers = serverRepository.findAll();


        // extract running cost
        // add them up in big decimal format
        BigDecimal sum = StreamSupport.stream(servers.spliterator(),false)
                .map(server -> server.getRunningCost())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        return sum;

    }

    public void updateCosts() {
        Iterable <Server> servers = serverRepository.findAll();
        servers.forEach(server -> {

            var currentCost = server.getReplacementCost();
            var updatedCost = currentCost.add(new BigDecimal("200.00"));
            server.setReplacementCost(updatedCost);

            serverRepository.save(server);

        });



    }





}