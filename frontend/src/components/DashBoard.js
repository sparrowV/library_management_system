import React from "react";
import Header from './Header';
import FindBook from './FindBook';


class DashBoard extends React.Component {
  render() {
    return (
      <div>
        <Header />
        <div>DashBoard</div>
        <FindBook/>

      </div>
    );
  }
}

export default DashBoard;
