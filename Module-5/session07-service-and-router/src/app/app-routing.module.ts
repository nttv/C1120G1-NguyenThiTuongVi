import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TimelinesComponent} from "./practices/timelines-app/timelines/timelines.component";
import {YoutubePlaylistComponent} from "./practices/youtube-player-app/youtube-playlist/youtube-playlist.component";
import {YoutubePlayerComponent} from "./practices/youtube-player-app/youtube-player/youtube-player.component";
import {DictionaryPageComponent} from "./exercises/dictionary-app/dictionary-page/dictionary-page.component";
import {DictionaryDetailComponent} from "./exercises/dictionary-app/dictionary-detail/dictionary-detail.component";
import {ProductListComponent} from "./exercises/product-management-app/product/product-list/product-list.component";
import {ProductCreateComponent} from "./exercises/product-management-app/product/product-create/product-create.component";
import {ProductUpdateComponent} from "./exercises/product-management-app/product/product-update/product-update.component";
import {ProductDeleteComponent} from "./exercises/product-management-app/product/product-delete/product-delete.component";

const routes: Routes = [
  {path: 'timelines', component: TimelinesComponent},
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{path: ':id', component: YoutubePlayerComponent}]
  },
  {path: 'dictionary', component: DictionaryPageComponent},
  {path: 'dictionary/:word', component: DictionaryDetailComponent},
  {
    path: 'product',
    component: ProductListComponent,
    children: [{path: 'delete/:id', component: ProductDeleteComponent}]
  },
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/edit/:id', component: ProductUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
