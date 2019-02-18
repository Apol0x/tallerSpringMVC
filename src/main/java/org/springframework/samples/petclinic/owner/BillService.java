package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

		@Autowired
		private BillRepository billRepository;
		
		
		public List<Bill> findAll() {
			return this.billRepository.findAll();
		}

		public Bill findById(int id) {
			return this.billRepository.findById(id);
		}
		
		public Bill saveBill(Bill b) {
			return this.billRepository.save(b);
		}
		
		public void deleteBill(int id) {
			this.billRepository.delete(id);
		}
}
