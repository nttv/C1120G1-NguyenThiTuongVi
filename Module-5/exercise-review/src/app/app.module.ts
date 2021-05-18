import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ListProductComponent} from './component/list-product/list-product.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {CreateProductComponent} from './component/create-product/create-product.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {UpdateProductComponent} from './component/update-product/update-product.component';
import {DetailProductComponent} from './component/detail-product/detail-product.component';
import {DeleteProductComponent} from './component/delete-product/delete-product.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    ListProductComponent,
    CreateProductComponent,
    UpdateProductComponent,
    DetailProductComponent,
    DeleteProductComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [DeleteProductComponent]
})
export class AppModule {
}
