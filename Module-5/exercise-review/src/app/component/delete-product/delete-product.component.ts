import {Component, Inject, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.scss']
})
export class DeleteProductComponent implements OnInit {

  description: string = '';
  id: number;

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router,
              private _dialogRef: MatDialogRef<DeleteProductComponent>,
              @Inject(MAT_DIALOG_DATA) private _modalData: any) {
  }

  ngOnInit(): void {
    this.id = this._modalData.id;
    this.description = this._modalData.description;
  }

  delete() {
    this._productService.delete(this.id).subscribe(() => {
      this._dialogRef.close(true);
      this._router.navigateByUrl('');
    });
  }

}
