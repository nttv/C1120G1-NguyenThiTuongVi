import {RouterModule, Routes} from '@angular/router';
import {ListProductComponent} from './component/list-product/list-product.component';
import {NgModule} from '@angular/core';
import {CreateProductComponent} from './component/create-product/create-product.component';
import {DetailProductComponent} from './component/detail-product/detail-product.component';
import {UpdateProductComponent} from './component/update-product/update-product.component';
import {DeleteProductComponent} from './component/delete-product/delete-product.component';

const routes: Routes = [
  {path: '', component: ListProductComponent},
  {path: 'create', component: CreateProductComponent},
  {path: ':id/detail', component: DetailProductComponent},
  {path: ':id/edit', component: UpdateProductComponent},
  // {path: ':id/delete', component: DeleteProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
