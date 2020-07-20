import React from "react";
import "./App.css";
import { Provider } from "react-redux";
import { store, persistor } from "./store";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Login from "./components/Login";
import DashBoard from "./components/DashBoard";
import SecureRoute from "./components/security/SecureRoute";
import Registration from "./components/Registration";
import Home from "./components/Home";
import AddBook from "./components/AddBook";
import { PersistGate } from "redux-persist/integration/react";

function App() {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <Router>
          <div className="App">
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Registration} />
            <Route exact path="/" component={Home} />

            <Switch>
              <SecureRoute exact path="/dashboard" component={DashBoard} />
              <SecureRoute exact path="/addBook" component={AddBook} />
            </Switch>
          </div>
        </Router>
      </PersistGate>
    </Provider>
  );
}

export default App;
