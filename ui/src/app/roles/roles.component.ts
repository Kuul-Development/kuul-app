import {Component, OnInit} from '@angular/core';
import {faTshirt, faPencilRuler, faBook, faChess, faCarrot, faPlug} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css']
})
export class RolesComponent implements OnInit {
  faTshirt = faTshirt;
  faPencilRuler = faPencilRuler;
  faBook = faBook;
  faChess = faChess;
  faCarrot = faCarrot;
  faPlug = faPlug;

  constructor() {
  }

  ngOnInit(): void {
  }

}
