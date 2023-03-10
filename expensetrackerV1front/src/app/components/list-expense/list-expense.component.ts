import { Component, OnInit } from '@angular/core';
import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-list-expense',
  templateUrl: './list-expense.component.html',
  styleUrls: ['./list-expense.component.css']
})
export class ListExpenseComponent implements OnInit {

  expenses: Expense[] = [];

  constructor(private _expenseSservice: ExpenseService) { }

  ngOnInit(): void {
    this._expenseSservice.getExpenses().subscribe(
      data => this.expenses = data
    );
  }

}
