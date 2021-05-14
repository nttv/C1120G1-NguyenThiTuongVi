import {Injectable} from '@angular/core';
import {Word} from "../model/word";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  words: Word[] = [{
    word: "hello",
    mean: "xin chào"
  }, {
    word: "goodbye",
    mean: "tạm biệt"
  }, {
    word: "morning",
    mean: "buổi sáng"
  }]

  constructor() {
  }

  getAll() {
    return this.words;
  }

  getOne(word: string) {
    return this.words.find(item => item.word === word);
  }

}
