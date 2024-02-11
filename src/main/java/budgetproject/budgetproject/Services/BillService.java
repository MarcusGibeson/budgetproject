package budgetproject.budgetproject.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import budgetproject.budgetproject.Models.Bill;
import budgetproject.budgetproject.Repositories.BillRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BillService {
    
    @Autowired
    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill save (Bill bill) {
        return billRepository.save(bill);
    }

    public Iterable<Bill> retrieveAllBills() {
        return billRepository.findAll();
    }

    public Bill retrieveBillById(Long id) throws Exception{
        try {
            return billRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception("Bill not found");
        }
    }

    public Bill getBillByName(String name) throws Exception {
        try{
            Bill bill = billRepository.findByName(name);
            return bill;
        } catch(Exception e){
            throw new Exception("Bill not found");
        }
    }

    public void deleteBill(Long billId) {
        Optional<Bill> billOptional = billRepository.findById(billId);
        if (billOptional.isPresent()) {
            Bill billToDelete = billOptional.get();
            billRepository.delete(billToDelete);
        } else {
            throw new EntityNotFoundException("Bill with Id " + billId + " was not found.");
        }
    }
}
