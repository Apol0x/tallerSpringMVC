package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bills")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Bill> getBills() {
		List<Bill> bill = billService.findAll();
		return bill;
    }
	
	@RequestMapping(value = "/{billId}", method = RequestMethod.GET)
	@ResponseBody
	public Bill findOne(@PathVariable(value = "billId") int billId) {
		return this.billService.findOne(billId);
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Bill> save(@RequestBody Bill b) {
		if(b != null)
			if(b.getId() != null)
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
			else
				return ResponseEntity.status(HttpStatus.OK).body(this.billService.saveBill(b));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.billService.saveBill(b));
	}
	
	@RequestMapping(value = "/{billId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Bill> update(@PathVariable(value = "billId") int billId, @RequestBody Bill b) {
		Bill b2 = billService.findOne(billId);
		if(b2 != null) {
			b.setId(billId);
			billService.saveBill(b);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		if(b != null)
			if(b.getId() != null)
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
			else
				return ResponseEntity.status(HttpStatus.OK).body(this.billService.saveBill(b));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.billService.saveBill(b));
	}
	
	@RequestMapping(value = "/{billId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable(value = "billId") int billId) {
		Bill b = billService.findOne(billId);
		if( b != null) {
			billService.deleteBill(billId);
	}
	}


}
