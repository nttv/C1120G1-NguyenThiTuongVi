import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ImageGalleryModule} from './practices/image-gallery/image-gallery.module';
import {GalleryConfig} from './practices/image-gallery/token';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ImageGalleryModule
  ],
  providers: [{provide: GalleryConfig, useValue: 2}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
