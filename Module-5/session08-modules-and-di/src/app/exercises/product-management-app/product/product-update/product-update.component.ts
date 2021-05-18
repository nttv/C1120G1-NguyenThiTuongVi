import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  product: any;
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
  });

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) {
  }

  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = parseInt(paramMap.get('id'));
      this.product = this._productService.getOneById(id);
      this.productForm.patchValue(this.product);
    });
  }

  submit() {
    const product = this.productForm.value;
    this._productService.updateProduct(product);
    this._router.navigateByUrl('/productC');
  }

}
