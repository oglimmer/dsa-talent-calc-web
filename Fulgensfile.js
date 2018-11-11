module.exports = {

  config: {
    SchemaVersion: "1.0.0",
    Name: "DSA-Talent-Calc",
    Vagrant: {
      Box: 'ubuntu/xenial64',
      Install: 'maven openjdk-8-jdk-headless docker.io'
    },
    JavaVersions: [ "1.8" ]
  },

  software: {

    dsatalentcalc: {
      Source: "mvn",
      Git: "https://github.com/oglimmer/dsa-talent-calc.git",
      Dir: "$$TMP$$/dsatalentcalc",
      Mvn: {
        Goal: "install"
      }
    },

    dsatalentcalcweb: {
      Source: "mvn",
      Artifact: "target/dsa-talent-calc##001.war",
    },

    tomcat: {
      Source: "tomcat",
      Deploy: "dsatalentcalcweb"
    }
  }

}
