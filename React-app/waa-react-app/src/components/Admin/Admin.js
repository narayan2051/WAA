import React, { useEffect, useState } from "react";
import { adminUrl, HTTPClient } from "../../api/API";

const Admin = (props) => {
  const [admindata, setAdmindata] = useState("");

  useEffect(() => {
    HTTPClient.get(adminUrl)
      .then((res) => {
        setAdmindata(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return <>{admindata}</>;
};

export default Admin;
