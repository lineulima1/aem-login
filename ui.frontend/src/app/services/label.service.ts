import { Injectable } from "@angular/core";
import { BehaviorSubject, Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class LabelService {
  private invalidLogin = new BehaviorSubject<boolean>(false);

  constructor() {}

  setInvalidLogin(isInvalid): void {
    this.invalidLogin.next(isInvalid);
  }

  getInvalidLogin(): Observable<boolean> {
    return this.invalidLogin.asObservable();
  }
}
