import {Component} from '@angular/core';
import {faUser, faBicycle, faStore, faCompressAlt} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  faBicycle = faBicycle;
  faUser = faUser;
  faStore = faStore;
  faCompressAlt = faCompressAlt;
}
