package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	public List<Bill> getBillByVisitNotNull();
	public List<Bill> getBillByVisitNull();
    public List<Bill> findAll();
    public Bill findById(int id);
    public Bill save(Bill b);
    public void delete(int id);

}