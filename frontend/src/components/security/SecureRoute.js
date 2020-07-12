import React from "react";
import { Route, Redirect } from "react-router-dom";
import { connect } from "react-redux";
import PropTypes from "prop-types";

const SecuredRoute = ({ component: Component, user, ...otherProps }) => {
  console.log("pig");
  return(
  <Route
    {...otherProps}
    render={props =>
      user.details ? (
        <Component {...props} />
      ) : (
        <Redirect to="/login" />
      )
    }
  />
  );
  };

SecuredRoute.propTypes = {
  user: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  user: state.user
});

export default connect(mapStateToProps)(SecuredRoute);