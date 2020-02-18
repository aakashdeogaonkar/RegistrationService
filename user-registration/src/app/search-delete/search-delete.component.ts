import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent implements OnInit {
  users: any;

  constructor(private service: UserRegistrationService) { }

  ngOnInit() {
    let resp = this.service.getUsers();
    resp.subscribe((data)=> this.users = data);
  }

}
