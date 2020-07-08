import React from "react";
import "./App.css";
import { Provider } from "react-redux";
import store from "./store";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from "./components/Login";
import DashBoard from "./components/DashBoard";
import SecureRoute from "./components/security/SecureRoute";
import Registration from "./components/Registration";
import Home from "./components/Home";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
         <Route exact path="/login" component={Login} />
         <Route exact path="/register" component={Registration}/> 
         <Route exact path="/" component={Home}/>
          <Switch>
            <SecureRoute exact path="/dashboard" component={DashBoard} />
          </Switch>
        </div>
      </Router>
    </Provider>
  );
}

export default App;
