import { action, makeObservable, observable } from "mobx";

class User {
  username: string = "";
  password: string = "";
  name: string = "";
  email: string = "";
  address: string = "";

  constructor() {
    makeObservable(this, {
      username: observable,
      name: observable,
      password: observable,
      email: observable,
      address: observable,
      //   setUsername: action,
      //   setName: action,
    });
  }
}

const userStore = new User();

export default userStore;
