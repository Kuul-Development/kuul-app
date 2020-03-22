import {Component} from '@angular/core';
import {
  faCoffee,
  faShoppingBag,
  faUser,
  faBars,
  faSearch,
  faTshirt,
  faPencilRuler,
  faBook,
  faChess,
  faCarrot,
  faPlug,
  faMapMarkerAlt
} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Kuul-App';
  faCoffee = faCoffee;
  faShoppingBag = faShoppingBag;
  faUser = faUser;
  faBars = faBars;
  faSearch = faSearch;
  faTshirt = faTshirt;
  faPencilRuler = faPencilRuler;
  faBook = faBook;
  faChess = faChess;
  faCarrot = faCarrot;
  faPlug = faPlug;
  faMapMarkerAlt = faMapMarkerAlt;
}
