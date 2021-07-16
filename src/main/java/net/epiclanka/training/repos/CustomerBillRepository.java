package net.epiclanka.training.repos;

import org.springframework.data.repository.CrudRepository;

import net.epiclanka.training.model.CustomerBill;

public interface CustomerBillRepository extends CrudRepository<CustomerBill,String> {

}
