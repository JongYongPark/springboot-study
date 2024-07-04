import React, { Component } from 'react';
import { withStyles, WithStyles } from '@material-ui/core/styles';
import { Grid, Paper, Typography, ListItem } from '@material-ui/core';

const styles = {
    image : {
        width : 80,
        height : 100,
    },

    itemArea : {
        width : 360,
    }
}

class BookListItem extends Component {
    render(){

        const { book, classes, onSelectedBook } = this.props;

        return(
            <ListItem onClick = { () => onSelectedBook(book) } >
                <Paper>
                    <Grid container spacing = {2}>
                        <Grid item>
                            <img className = { classes.image } src = { book.imgUrl } ></img>
                        </Grid>
                        <Grid item className = { classes.itemArea } >
                            <Typography component = 'h5' variant = 'h5' >
                                { book.title }
                            </Typography>
                            <Typography>
                                { book.author }
                            </Typography>
                        </Grid>
                    </Grid>
                </Paper>
            </ListItem>
        )
    }
}

export default withStyles(styles)(BookListItem);