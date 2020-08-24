package com.demisgomes.springboot.adapters.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConsolePriceJpa{
        @Id
        @GeneratedValue
        private Integer id;
        private String consoleName;
        private double priceInUSD;
        private double exchangeRate;
        private double taxPercentage;
        private double taxAmount;
        private double profitPercentage;
        private double profitAmount;
        private double priceInBRL;

        public ConsolePriceJpa(){}

        public ConsolePriceJpa(Integer id, String consoleName, double priceInUSD, double exchangeRate, double taxPercentage, double taxAmount, double profitPercentage, double profitAmount, double priceInBRL) {
                this.id = id;
                this.consoleName = consoleName;
                this.priceInUSD = priceInUSD;
                this.exchangeRate = exchangeRate;
                this.taxPercentage = taxPercentage;
                this.taxAmount = taxAmount;
                this.profitPercentage = profitPercentage;
                this.profitAmount = profitAmount;
                this.priceInBRL = priceInBRL;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getConsoleName() {
                return consoleName;
        }

        public void setConsoleName(String consoleName) {
                this.consoleName = consoleName;
        }

        public double getPriceInUSD() {
                return priceInUSD;
        }

        public void setPriceInUSD(double priceInUSD) {
                this.priceInUSD = priceInUSD;
        }

        public double getExchangeRate() {
                return exchangeRate;
        }

        public void setExchangeRate(double exchangeRate) {
                this.exchangeRate = exchangeRate;
        }

        public double getTaxPercentage() {
                return taxPercentage;
        }

        public void setTaxPercentage(double taxPercentage) {
                this.taxPercentage = taxPercentage;
        }

        public double getTaxAmount() {
                return taxAmount;
        }

        public void setTaxAmount(double taxAmount) {
                this.taxAmount = taxAmount;
        }

        public double getProfitPercentage() {
                return profitPercentage;
        }

        public void setProfitPercentage(double profitPercentage) {
                this.profitPercentage = profitPercentage;
        }

        public double getProfitAmount() {
                return profitAmount;
        }

        public void setProfitAmount(double profitAmount) {
                this.profitAmount = profitAmount;
        }

        public double getPriceInBRL() {
                return priceInBRL;
        }

        public void setPriceInBRL(double priceInBRL) {
                this.priceInBRL = priceInBRL;
        }
}