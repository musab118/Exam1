package edu.uh.tech.cis3368.exam;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Server {
    private int id;
    private String name;
    private String location;
    private BigDecimal replacementCost;
    private BigDecimal runningCost;

    public Server(String name, String location, BigDecimal replacementCost, BigDecimal runningCost) {
        this.name = name;
        this.location = location;
        this.replacementCost = replacementCost;
        this.runningCost = runningCost;
    }

    public Server() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "LOCATION", nullable = true, length = 120)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "REPLACEMENT_COST", nullable = true, precision = 4)
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return id == server.id &&
                Objects.equals(name, server.name) &&
                Objects.equals(location, server.location) &&
                Objects.equals(replacementCost, server.replacementCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, replacementCost);
    }

    @Basic
    @Column(name = "RUNNING_COST", nullable = true, precision = 4)
    public BigDecimal getRunningCost() {
        return runningCost;
    }

    public void setRunningCost(BigDecimal runningCost) {
        this.runningCost = runningCost;
    }
}
