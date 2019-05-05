import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterGame'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[], searchText: string): any[] {
    if(!value) {
      return [];
    }
    if(!searchText) {
      return value;
    }
    searchText = searchText.toLocaleLowerCase();   
    return value.filter(it => {
      return (it.game_name.toLocaleLowerCase().includes(searchText) || it.developer.toLocaleLowerCase().includes(searchText));
    });
  }

}
