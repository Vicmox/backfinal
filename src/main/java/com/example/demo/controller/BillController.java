package com.example.demo.controller;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.BillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    BillRepository billRepository;

    @GetMapping
    public List<Bill> getBillAll() {

        return billRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bill getBillsbyId(@PathVariable Integer id) {

        Optional<Bill> bill = billRepository.findById(id);

        if (bill.isPresent()) {
            return bill.get();
        }

        return null;
    }

    @PostMapping
    public Bill postUsuarios(@RequestBody Bill bill) {

        billRepository.save(bill);

        return bill;

    }

    @PutMapping("/{id}")
    public Bill putBillsbyId(@PathVariable Integer id, @RequestBody Bill bill) {

        Optional<Bill> billCurrent = billRepository.findById(id);

        if (billCurrent.isPresent()) {

            Bill billReturn = billCurrent.get();

            billReturn.setDate_bill(bill.getDate_bill());
            billReturn.setUsuario_id(bill.getUsuario_id());
            billReturn.setValor(bill.getValor());
            billReturn.setTipo(bill.getTipo());
            billReturn.setObservacion(bill.getObservacion());

            billRepository.save(billReturn);

            return billReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Bill deleteBillsbyId(@PathVariable Integer id) {

        Optional<Bill> bill = billRepository.findById(id);

        if (bill.isPresent()) {

            Bill billReturn = bill.get();

            billRepository.deleteById(id);

            return billReturn;
        }

        return null;

    }
}
