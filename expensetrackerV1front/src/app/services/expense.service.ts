import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators/map';
import { Expense } from '../models/expense';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  private baseUrl: string = "http://localhost:8080/api/v1/expenses";

  constructor(private _httpClient: HttpClient ) { }

  getExpenses(): Observable<Expense[]> {
    return this._httpClient.get<Expense[]>(this.baseUrl).pipe(
      map((response) => response )
    );
  }

  saveExpenses(expense: Expense): Observable<Expense> {
    return this._httpClient.post<Expense>(this.baseUrl,expense);
  }

  getExpense(id: number): Observable<Expense> {
    return this._httpClient.get<Expense>(`${this.baseUrl}/${id}`).pipe(
      map(response => response)
    );
  }

  deleteExpense(id: number): Observable<any>{
    return this._httpClient.delete(`${this.baseUrl}/${id}`,{responseType: 'text'});
  }
}
