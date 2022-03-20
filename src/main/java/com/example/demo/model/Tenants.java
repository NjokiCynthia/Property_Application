package com.example.demo.model;

import javax.persistence.*;


@Entity

@Table(name = "tenants")
public class Tenants {
    private int tenant_id;

    private String tenant_county;

    private String tenant_desc;

    private String tenant_fname;

    private String tenant_lname;

    @Enumerated(EnumType.STRING)
    private Property property;

    public Tenants() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTenant_county() {
        return tenant_county;
    }

    public void setTenant_county(String tenant_county) {
        this.tenant_county = tenant_county;
    }

    public String getTenant_desc() {
        return tenant_desc;
    }

    public void setTenant_desc(String tenant_desc) {
        this.tenant_desc = tenant_desc;
    }

    public String getTenant_fname() {
        return tenant_fname;
    }

    public void setTenant_fname(String tenant_fname) {
        this.tenant_fname = tenant_fname;
    }

    public String getTenant_lname() {
        return tenant_lname;
    }

    public void setTenant_lname(String tenant_lname) {
        this.tenant_lname = tenant_lname;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Tenants{" +
                "tenant_id=" + tenant_id +
                ", tenant_county='" + tenant_county + '\'' +
                ", tenant_desc='" + tenant_desc + '\'' +
                ", tenant_fname='" + tenant_fname + '\'' +
                ", tenant_lname='" + tenant_lname + '\'' +
                ", property=" + property +
                '}';
    }
}

  //  @Override
    //public boolean equals(Object o) {
      //  if (this == o) return true;
        //if (!(o instanceof Tenants)) return false;
        //Tenants tenants = (Tenants) o;
       // return getTenant_id() == tenants.getTenant_id() && Objects.equals(getTenant_county(), tenants.getTenant_county()) && Objects.equals(getTenant_desc(), tenants.getTenant_desc()) && Objects.equals(getTenant_fname(), tenants.getTenant_fname()) && Objects.equals(getTenant_lname(), tenants.getTenant_lname()) && getProperty() == tenants.getProperty();
   // }




