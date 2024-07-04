import React, { Component } from 'react';
import { TextField, InputAdornment } from '@material-ui/core';
import SearchIcon from '@material-ui/icons/Search';

class SearchBar extends Component {
    render(){

        const { onSearchTitle } = this.props;

        return(
            <TextField
                InputProps = { {
                    startAdornment : (
                        <InputAdornment position = 'start'>
                            <SearchIcon></SearchIcon>
                        </InputAdornment>
                    )
                } }
                onChange = { event => onSearchTitle(event.target.value) }
            />
        )
    }
}

export default SearchBar;