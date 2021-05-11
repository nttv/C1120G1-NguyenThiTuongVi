import {Component, OnInit} from '@angular/core';
import {Todo} from './model/todo';
import {FormControl} from '@angular/forms';

let _id = 1;

@Component({
  selector: 'app-practice-todo',
  templateUrl: './practice-todo.component.html',
  styleUrls: ['./practice-todo.component.css']
})

export class PracticeTodoComponent implements OnInit {

  todos: Todo[] = [];
  content = new FormControl();

  constructor() {
  }

  ngOnInit() {
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

}
