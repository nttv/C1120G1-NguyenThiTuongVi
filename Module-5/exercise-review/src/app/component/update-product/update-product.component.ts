import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ValidatorService} from '../../service/validator.service';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.scss']
})
export class UpdateProductComponent implements OnInit {

  updateForm: FormGroup;
  updateProduct: Product;
  origins: string[] = [];
  id: number;

  constructor(private _productService: ProductService,
              private _validatorService: ValidatorService,
              private _router: Router,
              private _formBuilder: FormBuilder,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._productService.setMessage('');
    this._productService.getOrigins().subscribe(data => {
      this.origins = data;
      console.log(this.origins);
    }, error => {
      console.log('getOrigins(): ' + error);
    });

    this.id = this._activatedRoute.snapshot.params['id'];

    this._productService.getById(this.id).subscribe(data => {
      this.updateProduct = data;
      this.initForm();
      this.updateForm.patchValue(data);
    }, error => {
      console.log('getById(): ' + error);
    });
  }

  initForm() {
    this.updateForm = this._formBuilder.group({
      name: ['', Validators.required],
      price: [0, [Validators.required, Validators.min(100000)]],
      productionDate: ['', [Validators.required, this._validatorService.before]],
      amount: [0, [Validators.required, Validators.min(0), Validators.max(100)]],
      origin: ['', Validators.required]
    });
  }

  update(updateForm: FormGroup) {
    if (updateForm.valid) {
      console.log(updateForm.value);
      this._productService.update(updateForm.value, this.id).subscribe(() => {
        this._productService.setMessage('Updated product successfully!!!');
        this._router.navigateByUrl('');
      }, error => {
        console.log('update(): ' + error);
      });
    }
  }

  setOrigin(origin: Event) {
    console.log('test: ' + origin.target);
    // this.updateForm.patchValue({origin: origin});
  }
}
