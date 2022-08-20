/* MIT License

Copyright (c) 2022 Thorben Stangenberg, thorben.stangenberg@42talents.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE. */
package dbutils;

import com._42talents.spring_boot_karate_example.Log;
import java.util.List;
import java.util.Map;

public class LogDatabase extends DbUtility<Log> {

  public LogDatabase(Map<String, Object> config) {
    super(config);
  }

  public boolean hasEntry(String text) {
    List<Log> logEntries = readRows("select id from log where text=?", Log.class, text);
    return logEntries.size() > 0;
  }

  public int deleteEntries(String text) {
    return update("delete from log where text=?", text);
  }
}
