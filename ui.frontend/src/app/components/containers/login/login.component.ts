import { Component, OnInit, Input } from "@angular/core";
import { MapTo } from "@adobe/aem-angular-editable-components";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  teste = false;
  @Input() inputs = [];
  @Input() text: string;
  @Input() imagens = [];

  constructor() {}

  ngOnInit(): void {}
}
MapTo("angularapp/components/login-component")(LoginComponent);
