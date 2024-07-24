package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity

public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private String creationDate;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(Client client, String creationDate) {
        this.client = client;
        this.creationDate = creationDate;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
