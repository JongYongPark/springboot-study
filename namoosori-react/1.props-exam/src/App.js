import React, { Component } from 'react';
import BookList from './components/BookList';
import Books from './static_data/Books';

// class App extends React.Component {
class App extends Component {
  // class 는 render method 필수로 구현
  render(){
    return(
      <BookList books={ Books } />
    )
  }
}

export default App;
