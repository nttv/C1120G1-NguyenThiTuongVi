import {Injectable} from '@angular/core';
import {addMonths, addYears, differenceInDays, differenceInMonths, differenceInYears} from 'date-fns';

@Injectable({
  providedIn: 'root'
})
export class DateUtilService {

  constructor() {
  }

  getDiffToNow(diff: string | number | Date): string {

    console.log(`Input: ${diff}`);

    const result: string[] = [];
    const now = new Date();
    diff = new Date(diff);

    console.log(`Now: ${now}`);
    console.log(`Input: ${diff}`);

    const years = differenceInYears(now, diff);

    console.log(`Years Diff: ${years}`)

    if (years > 0) {
      result.push(`${years} years`);
      diff = addYears(diff, years);

      console.log(`Input: ${diff}`);
    }

    const months = differenceInMonths(now, diff);

    console.log(`Months Diff: ${months}`)

    result.push(`${months} months`);
    if (months > 0) {
      diff = addMonths(diff, months);

      console.log(`Input: ${diff}`);

    }

    const days = differenceInDays(now, diff);

    console.log(`Days Diff: ${days}`)

    if (days > 0) {
      result.push(`${days} days`);
    }

    return result.join(' ');
  }

}
