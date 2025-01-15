package com.example.demo.controller.admin;

import java.text.AttributedCharacterIterator.Attribute;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService  uploadService;

    public ProductController(
        ProductService productService,
        UploadService  uploadService
    ){
        this.productService = productService;
        this.uploadService = uploadService;
    }
    
    // @GetMapping("/admin/product")
    // public String getProducts(){
    //     return "admin/product/show";  
    // }



    @RequestMapping("/admin/product/create")//GET
    public String getCreateProductPage(Model model){
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }


    @RequestMapping(value = "/admin/product/create", method = RequestMethod.POST)//POST
    public String createProductPage(Model model, 
                                @Valid @ModelAttribute("newProduct")  Product flower,
                                BindingResult newProductbindingResult,
                                @RequestParam("hoidanitFile") MultipartFile file
                                
                                )
                                
    {
        List<FieldError> errors = newProductbindingResult.getFieldErrors();
        for(FieldError error : errors){
            System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>......" + error.getField() + "-" + error.getDefaultMessage() );
        }

        if(newProductbindingResult.hasErrors()){
            return "admin/product/create";
        }


        String avatar = this.uploadService.handleSaveUploadFile(file, "products");     
        // String hashPassword = this.passwordEncoder.encode(hoidanit.getPassword());
        

        flower.setImage(avatar);
        // hoidanit.setPassword(hashPassword);
        // flower.setRole(this.productService.getRoleByName(flower.getRole().getName()));

        //save Product
        this.productService.handlSaveProduct(flower);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product")
    public String getProductPage(Model model){
        List<Product> flowers = this.productService.getAllProducts();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..>>check fowerlist : " + flowers);
        model.addAttribute("flowers1", flowers);//(gia tri nhan duoc ben  view, gia tri ben controller)
        return "admin/product/show";
    }

    @RequestMapping("/admin/product/{id}")//GET
    public String getProductDetailPage(Model model, @PathVariable long id){
        Product flower = this.productService.getProductById(id).get();
        model.addAttribute("flower", flower); 
        return "admin/product/detail";
    }

    @GetMapping("/admin/product/delete/{id}")//GET
    public String getDeleteProductPage(Model model, @PathVariable long id){
        model.addAttribute("id", id); 
        model.addAttribute("newProduct", new Product()); 

        return "admin/product/delete";
    }


    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.POST)//POST
    public String postDeleteProduct(Model model, @ModelAttribute("newProduct") Product flower){
        this.productService.deleteProductById(flower.getId());
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/update/{id}")//GET
    public String getUpdateProductPage(Model model, @PathVariable long id){
        Product currentProduct = this.productService.getProductById(id).get();
        model.addAttribute("newProduct", currentProduct); 
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")//POST
    public String postUpdateProduct(Model model,
                                    @ModelAttribute("newProduct") Product hoidanit,
                                    BindingResult newProductbindingResult,
                                    @RequestParam("hoidanitFile") MultipartFile file
                                    ){
        
        //validate data
        if(newProductbindingResult.hasErrors()){
            return "admin/product/update";
        }
        
        
        Product currentProduct = this.productService.getProductById(hoidanit.getId()).get();

        if(currentProduct != null){

            if(!file.isEmpty()){
                String img = this.uploadService.handleSaveUploadFile(file, "products");     
                currentProduct.setImage(img);
            }

            currentProduct.setName(hoidanit.getName());
            currentProduct.setPrice(hoidanit.getPrice());
            currentProduct.setDetailDesc(hoidanit.getDetailDesc());
            currentProduct.setShortDesc(hoidanit.getShortDesc());
            currentProduct.setQuantity(hoidanit.getQuantity());
            currentProduct.setFactory(hoidanit.getFactory());
            currentProduct.setTarget(hoidanit.getTarget());

            this.productService.handlSaveProduct(currentProduct);
        }        
        return "redirect:/admin/product";
    }
    

}