import React, { Component } from 'react';
import { List } from '@material-ui/core';
import BookListItem from './BookListItem';

class BookList extends Component {
    render(){
        const bookIems = this.props.books.map( book => {
            return (
                <BookListItem
                    book = { book }
                    key = { book.ISBN }
                    onSelectedBook = { this.props.onSelectedBook }
                />
            )
        });

        return(
            <List>
                { bookIems }
            </List>
        )
    }
}

export default BookList;