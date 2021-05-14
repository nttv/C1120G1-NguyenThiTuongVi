import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TimelinesComponent} from './practices/timelines-app/timelines/timelines.component';
import {AppRoutingModule} from "./app-routing.module";
import {YoutubePlaylistComponent} from './practices/youtube-player-app/youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './practices/youtube-player-app/youtube-player/youtube-player.component';
import {ReactiveFormsModule} from "@angular/forms";
import {DictionaryPageComponent} from './exercises/dictionary-app/dictionary-page/dictionary-page.component';
import {DictionaryDetailComponent} from './exercises/dictionary-app/dictionary-detail/dictionary-detail.component';
import {ProductListComponent} from "./exercises/product-management-app/product/product-list/product-list.component";
import {ProductCreateComponent} from "./exercises/product-management-app/product/product-create/product-create.component";
import { ProductUpdateComponent } from './exercises/product-management-app/product/product-update/product-update.component';
import { ProductDeleteComponent } from './exercises/product-management-app/product/product-delete/product-delete.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    ProductListComponent,
    ProductCreateComponent,
    DictionaryPageComponent,
    DictionaryDetailComponent,
    ProductUpdateComponent,
    ProductDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
