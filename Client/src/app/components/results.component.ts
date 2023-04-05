import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Movies } from '../models/movies';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css'],
})
export class ResultsComponent implements OnInit, OnDestroy {
  query = '';
  param$!: Subscription;
  movies!: Movies[];
  currentIndex!: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private movieSvc: MovieService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.param$ = this.activatedRoute.params.subscribe(async (params) => {
      this.query = params['query'];
      console.log(this.query);
      const l = await this.movieSvc.searchReviews(this.query);
      this.currentIndex = 1;
      console.log(l);
      if (l === undefined || l.length == 0) {
        this.router.navigate(['/']);
      } else {
        this.movies = l;
      }
    });
  }

  ngOnDestroy(): void {
    console.log('destroy sub');
    this.param$.unsubscribe();
  }
}
