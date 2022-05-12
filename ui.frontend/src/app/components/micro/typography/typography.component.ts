import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-typography",
  templateUrl: "./typography.component.html",
  styleUrls: ["./typography.component.css"],
})
export class TypographyComponent implements OnInit {
  @Input() text: string;
  @Input() color: string;
  constructor() {}

  ngOnInit(): void {}
}
