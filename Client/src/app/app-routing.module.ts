import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchComponent } from './components/search.component';
import { ResultsComponent } from './components/results.component';
import { CommentsComponent } from './components/comments.component';

const routes: Routes = [
  { path: '', component: SearchComponent },
  { path: 'results/:query', component: ResultsComponent },
  { path: 'comments', component: CommentsComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
