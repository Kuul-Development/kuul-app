import {Component} from '@angular/core';
import {faShoppingBag, faUser, faBars, faSearch} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  faBars = faBars;
  faUser = faUser;
  faShoppingBag = faShoppingBag;
  faSearch = faSearch;
}
