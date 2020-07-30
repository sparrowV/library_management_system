import React from "react";
import Header from "./Header";
import FindBook from "./FindBook";
import CustomPaginationActionsTable from "./CustomTable";




class DashBoard extends React.Component {
  constructor() {
    super();

    this.state = {
      bookSearchParams: {},
    };
    this.onSearchBook = this.onSearchBook.bind(this);
  }

  onSearchBook(title, authorName) {
    console.log(title, authorName);
    this.setState({
      bookSearchParams: {
        title: title,
        authorName: authorName,
      },
    });
    console.log(this.state);
  }

  render() {
    const style={
      display:'flex',
      margin:'2em'
    }


    return (
      <div>
        <Header selectedTabIndex={0} />
        <div style={style}>
          <FindBook onSearchBook={this.onSearchBook} />
          <CustomPaginationActionsTable
            searchParams={this.state.bookSearchParams}
          />
        </div>
      </div>
    );
  }
}

export default DashBoard;
