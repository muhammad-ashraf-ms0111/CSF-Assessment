import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movies } from '../models/movies';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MovieService {
  private API_URI: string = '/api/reviews';

  constructor(private httpClient: HttpClient) {}

  searchReviews(query: string): Promise<any> {
    const params = new HttpParams().set('query', query);

    const headers = new HttpHeaders().set(
      'Content-Type',
      'application/json; charset=utf-8'
    );

    return lastValueFrom(
      this.httpClient.get<Movies[]>(this.API_URI, {
        params: params,
        headers: headers,
      })
    );
  }
}
