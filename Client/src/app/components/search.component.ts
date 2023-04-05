import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit, OnDestroy {
  form!: FormGroup;
  query?: string;

  constructor(private formBuilder: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.form = this.createForm();
  }

  ngOnDestroy(): void {}

  search() {
    const query = this.form?.value['query'];
    this.router.navigate(['/results', query]);
  }

  private createForm(): FormGroup {
    return this.formBuilder.group({
      query: this.formBuilder.control<string>('', [
        Validators.required,
        Validators.minLength(2),
      ]),
    });
  }
}
