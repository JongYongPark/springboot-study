import React, { Component } from 'react';
import { Card, CardHeader, CardMedia, CardContent, Typography } from '@material-ui/core';
import { withStyles, WithStyles } from '@material-ui/core/styles';

const style = {
    root : {
        maxWidth : 450,
    },

    media : {
        width : '70%',
        height : '70%',
    }
}


class BookDetail extends Component {
    render(){

        const { book, classes } = this.props;

        return(
            <Card className = { classes.root } >
                <CardHeader title = { book.title } subheader = { book.author } ></CardHeader>
                <CardMedia 
                    component = 'img' 
                    image = { book.imgUrl } 
                    className = { classes.media } >

                </CardMedia>
                <CardContent>
                    <Typography variant= 'body2' color = 'textSecondary' component = 'p' >
                        { book.introduce }
                    </Typography>
                </CardContent>
            </Card>
        )
    }
}

export default withStyles(style)(BookDetail);