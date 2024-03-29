package uz.malga.logisticcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.malga.logisticcompany.payload.DazvolSaleDto;
import uz.malga.logisticcompany.service.DazvolSaleService;
import uz.malga.logisticcompany.utils.AppConstants;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dazvolSale")
public class DazvolSaleController {

    @Autowired
    DazvolSaleService dazvolSaleService;

    @PostMapping("/save")
    public HttpEntity<?> saveOrEdit(@RequestBody DazvolSaleDto dto){
        return ResponseEntity.ok(dazvolSaleService.saveOrEdit(dto));
    }

    @GetMapping("/allByPageable")
    public HttpEntity<?> allByPageable(@RequestParam(value = "page",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER)Integer page,
                                       @RequestParam(value = "size",defaultValue = AppConstants.DEFAULT_PAGE_SIZE)Integer size,
                                       @RequestParam(value = "search",defaultValue = "all") String search,
                                       @RequestParam(value = "active",defaultValue = "true") boolean active,
                                       @RequestParam(value = "companyId") Long companyId
    ) throws IllegalAccessException {
        return ResponseEntity.ok(dazvolSaleService.allByPageable(page,size,search,companyId));
    }

    @GetMapping("/delete")
    public HttpEntity<?>delete(@RequestParam(value = "ids",defaultValue = "0") List<UUID> id){
        return ResponseEntity.ok(dazvolSaleService.delete(id));
    }
}
